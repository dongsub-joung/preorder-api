//package com.preOrder.api.domain;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
//import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
//import jakarta.persistence.*;
//import org.springframework.data.annotation.CreatedDate;
//
//import java.time.LocalDateTime;
//
//import lombok.*;
//@Entity
//@Builder
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Post {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    long id;
//
//    @Column(name = "tixtle")
//    String title;
//
//    @Column(name = "body")
//    String body;
//
//    @Column(name = "author_id")
//    long author_id;
//
//    @Column(name = "createdAt")
//    @CreatedDate
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    @JsonSerialize(using = LocalDateSerializer.class)
//    @JsonDeserialize(using = LocalDateDeserializer.class)
//    LocalDateTime createdAt;
//}
