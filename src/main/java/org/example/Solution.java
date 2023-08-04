package org.example;

import java.util.*;
class P42579 {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Music> playList = new ArrayList<>();
        HashMap<String, Integer> genrePlayed = new HashMap<>();

        // 곡 정보를 Music 객체로 생성하여 리스트에 추가
        for (int i = 0; i < genres.length; i++) {
            Music music = new Music(genres[i], plays[i], i);
            playList.add(music);
        }

        // 장르별 총 재생 횟수 계산
        for (Music x : playList) {
            genrePlayed.put(x.getGenres(), genrePlayed.getOrDefault(x.getGenres(), 0) + x.getPlays());
        }

        // 장르를 총 재생 횟수 내림차순으로 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlayed.keySet());
        sortedGenres.sort((a, b) -> genrePlayed.get(b) - genrePlayed.get(a));

        ArrayList<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            ArrayList<Music> genreSongs = new ArrayList<>();

            // 현재 장르의 곡들을 추려내고, 재생 횟수와 번호 순으로 정렬
            for (Music music : playList) {
                if (music.getGenres().equals(genre)) {
                    genreSongs.add(music);
                }
            }
            genreSongs.sort((a, b) -> a.getPlays() == b.getPlays() ? a.getNum() - b.getNum() : b.getPlays() - a.getPlays());

            // 장르 내에서 최대 두 곡 선택
            int count = 0;
            for (Music music : genreSongs) {
                result.add(music.getNum());
                count++;
                if (count >= 2) {
                    break;
                }
            }
        }

        // 결과를 배열로 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}

class Music{
    private String genres;
    private int plays;
    private int num;

    public Music(String genres, int plays, int num){
        this.genres=genres;
        this.plays=plays;
        this.num=num;
    }

    public String getGenres(){
        return this.genres;
    }

    public int getPlays(){
        return this.plays;
    }
    public int getNum(){
        return this.num;
    }

    @Override
    public String toString(){
        return "genres : " + this.genres + " plays : " + this.plays + " num : " + this.num;
    }
}