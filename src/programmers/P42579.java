package programmers;

import java.util.*;
//베스트앨범
public class P42579 {
    public static void main(String[] args) {
        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop", "rock", "rock"};
        int[] plays = new int[]{500, 600, 150, 800, 2500, 150, 150};

        int[] solution = new P42579().solution(genres, plays);

        for(int e : solution) {
            System.out.println(e);
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        final int len = genres.length;

        Map<String, SongVO> songs = new HashMap<>();

        for(int i=0; len>i; i++) {

            if(songs.containsKey(genres[i])) {
                songs.get(genres[i]).totalPlays+=+plays[i];

                songs.get(genres[i]).songs.add(new SongDVO(i,plays[i]));
            } else {
                SongVO vo = new SongVO();
                vo.totalPlays = plays[i];
                vo.songs.add(new SongDVO(i,plays[i]));

                songs.put(genres[i],vo);
            }
        }

        //장르 정렬
        Set<String> keySet = songs.keySet();

        List<GenresVO> genresVOS = new ArrayList<>(keySet.size());

        for(String key : keySet) {
            genresVOS.add(new GenresVO(songs.get(key).totalPlays,key));
        }

        genresVOS.sort((o1, o2) -> Integer.compare(o2.totalPlays,o1.totalPlays));

        List<Integer> answer = new ArrayList<>();

        for(GenresVO vo : genresVOS) {
            SongVO songVO = songs.get(vo.genres);
            songVO.songs.sort( ((o1, o2) -> Integer.compare(o2.plays, o1.plays)));
            songVO.songs.sort( ((o1, o2) -> {
                if(o1.plays != o2.plays) return Integer.compare(o2.plays, o1.plays);
                else {
                    return Integer.compare(o1.index, o2.index);
                }
            }));
            int groupCnt = 2;

            for(SongDVO songDVO : songVO.songs) {
                groupCnt--;
                if(groupCnt < 0) break;
                answer.add(songDVO.index);
            }
        }

        int[] a = new int[answer.size()];

        for(int j=0; a.length>j; j++) {
            a[j] = answer.get(j);
        }

        return a;
    }

    class SongVO {
        int totalPlays;//장르별 전체 재생수
        List<SongDVO> songs; //고유값, 재생수의 각 노래 들

        public SongVO() {
            this.songs = new ArrayList<>();
        }
    }

    class SongDVO {
        int index;
        int plays;

        public SongDVO(int index, int plays) {
            this.index = index;
            this.plays = plays;
        }
    }

    class GenresVO {
        int totalPlays;//장르별 전체 재생수
        String genres;

        public GenresVO(int totalPlays, String genres) {
            this.totalPlays = totalPlays;
            this.genres = genres;
        }
    }
}
