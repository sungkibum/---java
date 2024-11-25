package org.example.ll.domain.wiseSaying.entity;

public class WiseSaying {
        private int id;
        public String saying;
        public String author;

        public WiseSaying(int id, String saying, String author) {
            this.id = id;
            this.saying = saying;
            this.author = author;
        }

        public int getId() {
            return id;
        }

        public String getSaying() {
            return saying;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return id + "\n" + saying + "\n" + author;
        }
    }

