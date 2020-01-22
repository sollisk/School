
public class UASong {
		private String artist;
		private String songName;
		private int playTime;

		public UASong(String artist, String songName, int playTime) {
			this.artist = artist;
			this.songName = songName;
			this.playTime = playTime;
		}

		// Getters and Setters
		public String getArtist() {
			return artist;
		}

		public void setArtist(String artist) {
			this.artist = artist;
		}

		public String getSongName() {
			return songName;
		}

		public void setSongName(String songName) {
			this.songName = songName;
		}

		public int getPlayTime() {
			return playTime;
		}

		public void setPlayTime(int playTime) {
			this.playTime = playTime;
		}

		public String toString() {
			return String.format("Artist: " + artist + " Song Name: " + songName + " Play Time: " + playTime);
		}

	}

