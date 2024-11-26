package org.example.ll.domain.wiseSaying.controller;

import org.example.ll.domain.wiseSaying.entity.WiseSaying;
import org.example.ll.domain.wiseSaying.service.WiseSayingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private WiseSayingService wiseSayingService = new WiseSayingService();
    Scanner sc = new Scanner(System.in);

    public void actionAdd() {
        System.out.print("명언 : ");
        String saying = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();
        WiseSaying wiseSaying = wiseSayingService.addWiseSaying(saying, author);

        System.out.println(wiseSaying.getId() + "번 명언이 등록되었습니다.");
    }


    public void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------");
        List<WiseSaying> wiseSayingList = wiseSayingService.findAll();
        for (WiseSaying wiseSaying : wiseSayingList) {
            System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getSaying());
        }
    }

    public void actionDelete() {
        System.out.print("?id=");
        int idNum = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        if (wiseSayingService.deleteWiseSaying(idNum) == 0) {
            System.out.println(idNum + "번 명언은 존재하지 않습니다.");
        } else {
            System.out.println(idNum + "번 명언은 삭제되었습니다.");
        }
    }

    public void actionModify() {
        System.out.print("?id=");
        int idNum = sc.nextInt();
        sc.nextLine();
        wiseSayingService.modifyWiseSaying(idNum);
    }
}

