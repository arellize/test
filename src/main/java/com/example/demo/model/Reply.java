package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 200)
	private String content;

	@ManyToOne
	@JoinColumn(name = "boardId")
	private Board board;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	@DateTimeFormat(pattern = "yyyy-mm-dd HH:mm")
	private LocalDate createDate;

	@PrePersist
	public void createDate() {
		this.createDate = LocalDate.now();
	}
}
