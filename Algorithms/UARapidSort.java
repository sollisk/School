import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*  Student Name: 	Solomon Lisk
 *  Username:		ua307		
 *  Date:			10/5/19
 *  Class:          CS 3103 - Algorithm Design
 */
public class UARapidSort {
	private int left(int i) {
		return (2 * i) + 1;
	}

	private int right(int i) {
		return (2 * i) + 2;
	}

	private int parent(int i) {
		return i / 2;
	}

	public int[] insertionSort(int[] sortList) {
		for (int i = 1; i < sortList.length; i++) {
			int key = sortList[i];
			int j = i - 1;
			while (j >= 0 && sortList[j] > key) {
				sortList[j + 1] = sortList[j];
				j = j - 1;
			}
			sortList[j + 1] = key;
		}
		return sortList;
	}

	public int[] merge(int[] sortList, int[] leftArray, int[] rightArray, int left, int right) {
		int i = 0, rightArrayIndex = 0, leftArrayIndex = 0;
		while (i < left && rightArrayIndex < right) {
			if (leftArray[i] <= rightArray[rightArrayIndex]) {
				sortList[leftArrayIndex++] = leftArray[i++];
			} else {
				sortList[leftArrayIndex++] = rightArray[rightArrayIndex++];
			}
		}
		while (i < left) {
			sortList[leftArrayIndex++] = leftArray[i++];
		}
		while (rightArrayIndex < right) {
			sortList[leftArrayIndex++] = rightArray[rightArrayIndex++];
		}
		return sortList;
	}

	public int[] mergeSort(int[] sortList, int length) {
		if (length < 2) {
			return sortList;
		}
		int midPoint = length / 2;
		int[] left = new int[midPoint];
		int[] right = new int[length - midPoint];

		for (int i = 0; i < midPoint; i++) {
			left[i] = sortList[i];
		}
		for (int j = midPoint; j < length; j++) {
			right[j - midPoint] = sortList[j];
		}
		mergeSort(left, midPoint);
		mergeSort(right, length - midPoint);

		merge(sortList, left, right, midPoint, length - midPoint);
		return sortList;
	}

	void heapifyUp(int[] sortList, int n, int index) {
		int left = left(index), right = right(index), largest = index;
		if (left < n && sortList[left] > sortList[largest]) {
			largest = left;
		}
		if (right < n && sortList[right] > sortList[largest]) {
			largest = right;
		}
		if (largest != index) {
			int temp = sortList[index];
			sortList[index] = sortList[largest];
			sortList[largest] = temp;
			heapifyUp(sortList, n, largest);
		}
	}

	public int[] heapSort(int[] sortList) {
		int n = sortList.length, i;
		for (i = parent(n) - 1; i >= 0; i--) {
			heapifyUp(sortList, n, i);
		}
		for (i = n - 1; i >= 0; i--) {
			int temp = sortList[0];
			sortList[0] = sortList[i];
			sortList[i] = temp;
			heapifyUp(sortList, i, 0);
		}
		return sortList;
	}

	public int[] quickSort(int[] sortList, int sIndex, int eIndex) {
		if (sIndex < eIndex) {
			int partPoint = partition(sortList, sIndex, eIndex);
			quickSort(sortList, sIndex, partPoint - 1);

			quickSort(sortList, partPoint + 1, eIndex);
		}
		return sortList;
	}

	public int partition(int[] sortList, int sIndex, int eIndex) {
		int pivot,i = sIndex - 1;
		if (sortList.length >= 2) {
			pivot = sortList[eIndex];
		} else {
			pivot = sortList[selectPivot(sortList, sIndex, eIndex)];
		}

		for (int j = sIndex; j < eIndex; j++) {
			if (sortList[j] < pivot) {
				i++;
				int temp = sortList[i];
				sortList[i] = sortList[j];
				sortList[j] = temp;
			}

		}
		int temp = sortList[i + 1];
		sortList[i + 1] = sortList[eIndex];
		sortList[eIndex] = temp;

		return (i + 1);
	}

	public int selectPivot(int[] sortList, int sIndex, int eIndex) {
		int pivot = (sIndex + eIndex) / 2;
		return pivot;
	}

	public void fileList(final File folder) throws IOException {
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            fileList(fileEntry);
	        } else {
	        	String filename = folder+"\\"+fileEntry.getName();
	        	int[] sortList=loadArray(filename);
	        	getBestSort(sortList);
	        	saveDataToFile(filename,sortList);
	        	System.out.println("");
	        }
	    }
	}
	public void fileListQuick(final File folder) throws IOException {
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            fileList(fileEntry);
	        } else {
	        	String filename = folder+"\\"+fileEntry.getName();
	        	int[] sortList=loadArray(filename);
	        	quickSort(sortList,0,sortList.length-1);
	        	saveDataToFile(filename,sortList);
	        	System.out.println("");
	        }
	    }
	}
	public int getLength(String fileName) {
		int length = 0;
		String line="";
		try {
			FileReader fileReader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				length=line.replace(" ", "").length();
			}
			fileReader.close();
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
		return length;
	}
	public int[] loadArray(String fileName) {
		String line;
		int arraySize = getLength(fileName);
		int[] list = new int [arraySize];
		String[] stringList = new String[arraySize];
		
		try {
			FileReader fileReader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				stringList = line.split(" ");
			}
			for(int j=0;j<stringList.length;j++) {
				list[j] = Integer.parseInt(stringList[j]);
			}
			fileReader.close();
			bufferedReader.close();
			return list;
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
		return null;
	}
	public void saveDataToFile(String filename, int [] sortList)throws IOException {
		FileWriter fileWriter = new FileWriter(filename);
		PrintWriter printWriter= new PrintWriter(fileWriter);
		
		for(int i=0;i<=sortList.length-1;i++) {
			printWriter.print(sortList[i]+" ");
		}
		printWriter.close();
	}
	public void getBestSort(int[] sortList) {
		if (sortList.length<20) {
			insertionSort(sortList);
			System.out.println("Insertion Sort was used");
		} else if(sortList.length%2==0) {
			mergeSort(sortList,sortList.length);
			System.out.println("Merge Sort was used");
		}else {
			quickSort(sortList,0,sortList.length-1);
			System.out.println("Quick Sort was used");
		}
	}
	
	public static void main(String[] args) throws IOException {
		UARapidSort sort = new UARapidSort();
		final File folder = new File(args[0]);
		
		if(args[2].contentEquals("fast")) {
			sort.fileList(folder);
		} else if(args[2].contentEquals("uaquicksort")) {
			sort.fileListQuick(folder);
		}
//		final File folder = new File("C:\\Users\\User\\Desktop\\Test");
//		sort.fileList(folder);
		
	}

}
