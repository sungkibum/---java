package org.example.ll.domain.wiseSaying.controller;

import org.example.ll.domain.wiseSaying.entity.WiseSaying;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WiseSayingController {
    ArrayList<WiseSaying> wiseSayingList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    int index = 1;





    public void actionAdd() {
        System.out.print("명언 : ");
        String saying = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        WiseSaying newWiseSaying = new WiseSaying(index, saying, author);
        wiseSayingList.add(newWiseSaying);



        System.out.println(index + "번 명언이 등록되었습니다.");
        index++;
    }

    public void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------");
        for (WiseSaying wiseSaying : wiseSayingList) {
            System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getSaying());
        }
    }

    public void actionDelete() {
        System.out.print("?id=");
        int idNum = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기
        boolean check = false;
        for (WiseSaying wiseSaying : wiseSayingList) {
            if (idNum == wiseSaying.getId()) {
                wiseSayingList.remove(wiseSaying);
                System.out.println(idNum + "번 명언이 삭제되었습니다.");
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println(idNum + "번 명언은 존재하지 않습니다.");
        }
    }

    public void actionModify() {
        System.out.print("?id=");
        int idNum = sc.nextInt();
        sc.nextLine();
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

