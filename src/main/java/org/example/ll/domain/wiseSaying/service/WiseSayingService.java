package org.example.ll.domain.wiseSaying.service;

import org.example.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingService {
    private List<WiseSaying> wiseSayingList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);


    public WiseSaying addWiseSaying(String saying, String author) {
        WiseSaying wiseSaying = new WiseSaying(0, saying, author);
        wiseSayingList.add(wiseSaying);
        return wiseSaying;
    }
    public List<WiseSaying> findAll() {
        return wiseSayingList;
    }

    public int deleteWiseSaying(int idNum) {
        boolean check = false;
        for (WiseSaying wiseSaying : wiseSayingList) {
            if (idNum == wiseSaying.getId()) {
                wiseSayingList.remove(wiseSaying);
                check = true;
                break;
            }
        }
        if (check) {
            return 0;
        }
        return idNum;
    }

    public void modifyWiseSaying(int idNum) {
        boolean check = false;
        for (WiseSaying wiseSaying : wiseSayingList) {
            if (idNum == wiseSaying.getId()) {
                System.out.println("명언(기존) : " + wiseSaying.getSaying());
                System.out.print("명언 : ");
                String newSaying = sc.nextLine();
                System.out.println("작가(기존) : " + wiseSaying.getAuthor());
                System.out.print("작가 : ");
                String newAuthor = sc.nextLine();

                // 데이터 수정
                wiseSaying.saying = newSaying;
                wiseSaying.author = newAuthor;


                System.out.println(idNum + "번 명언이 수정되었습니다.");
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println(idNum + "번 명언은 존재하지 않습니다.");
        }

    }
}
