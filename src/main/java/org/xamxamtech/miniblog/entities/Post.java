package org.xamxamtech.miniblog.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int author;
    private Date date;
    private String content;
    private String title;
    private String status;
    private String name;
    private String type;
    private String category;
    @ManyToOne
    private User user;


}
