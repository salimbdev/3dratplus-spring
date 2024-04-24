package fr.eql.ai115.three.d.rat.plus.spring.entity.dto;

import java.time.LocalDate;

public class CommentProductDto {


        private String content;
        private Long idUser;
        private LocalDate dateOfPublication;
        private double rating;
        private String title;

        public CommentProductDto() {
        }

        public CommentProductDto(String content, Long idUser, LocalDate dateOfPublication, double rating, String title) {
            this.content = content;
            this.idUser = idUser;
            this.dateOfPublication = dateOfPublication;
            this.rating = rating;
            this.title = title;
        }


        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Long getIdUser() {
            return idUser;
        }

        public void setIdUser(Long idUser) {
            this.idUser = idUser;
        }

        public LocalDate getDateOfPublication() {
            return dateOfPublication;
        }

        public void setDateOfPublication(LocalDate dateOfPublication) {
            this.dateOfPublication = dateOfPublication;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
}
