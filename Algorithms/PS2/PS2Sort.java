import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PS2Sort implements UAInterface{

	public void sortBySong() {
		UASong[] songList=loadArray();
		for(int i=0;i<songList.length;i++) {
			System.out.println(songList[i].getSongName());
		}
		
	}




	@Override
	public void insertionSort(UASong[] A) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void bubbleSort(UASong[] A) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mergeSort(UASong[] A) {
		// TODO Auto-generated method stub
		
	}


	public static UASong[] loadArray() {
		System.out.println("Type a filename.");
		Scanner sc = new Scanner(System.in);
		String fileName= sc.nextLine();
		String line = "";
		int i=0;
		UASong[] songList = new UASong[2];
		try {
			FileReader fileReader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				String[] output= line.split(",");
				String artist = output[0];
				String songName = output[1];
				int playTime = Integer.parseInt(output[2]);
				
				songList[i] = new UASong(artist,songName,playTime);
				i++;
			}
			fileReader.close();
			bufferedReader.close();
			sc.close();
			return songList;
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
		sc.close();
		return null;
	}

	public static void main(String[] args) {
		sortBySong();
	}
	

}
