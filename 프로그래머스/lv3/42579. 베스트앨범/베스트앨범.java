import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        Map<String, Integer> genresMap = new TreeMap<>();
        List<Song> songList = new ArrayList<>();
        
        for(int i=0; i<genres.length; i++){
            genresMap.put(genres[i], genresMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        for(int i=0; i<genres.length; i++){
            songList.add(new Song(i, genres[i], plays[i], genresMap.get(genres[i])));
        }


        Collections.sort(songList);

        List<Integer> result = new ArrayList<>();
        String genre = songList.get(0).genre;
        int cnt = 0;
        for(int i=0; i<songList.size(); i++){    
            
            if(genre.equals(songList.get(i).genre)){
                cnt++;
            }else{
                cnt = 1;
                genre = songList.get(i).genre;
            }
            
            if(cnt <= 2){
                result.add(songList.get(i).num);
            }
        }

        
        return result.stream().mapToInt(i-> i).toArray();
    }
    
    public static class Song implements Comparable<Song>{
        int num;
        String genre;
        int play;
        int count;
        
        public Song(int num, String genre, int play, int count){
            this.num = num;
            this.genre = genre;
            this.play = play;
            this.count = count;
        }
        
        public int compareTo(Song s){
            if(this.play==s.play) return this.num - s.num;
            if(this.count==s.count) return s.play - this.play;
            return s.count - this.count;
        }
    }
}