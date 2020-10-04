package com.untact.domain.board;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import com.untact.domain.group.GroupEntity;
import com.untact.domain.member.MemberEntity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@Entity
@SequenceGenerator(name="b_seq", initialValue=1, allocationSize=1)
@EqualsAndHashCode(of="bno")
public class Board {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="b_seq")
	private Long bno;//게시판 글 번호
	
	private String title;//게시판 글 제목
	
	private String content;//게시판 글 내용
	
	@Enumerated(EnumType.ORDINAL)
	@NotNull
	private Kind kind;//게시판 글 종류(일반 글인지 질의 응답인지)
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@CreationTimestamp
	private LocalDateTime regdate;//게시판 등록 시간
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@UpdateTimestamp
	private LocalDateTime updatedate;//게시판 수정 시간
	
	@ManyToOne
	@JoinColumn
	private GroupEntity group;//어떤 그룹이 이 글을 썻는지 나타냄
	public void setGroup(GroupEntity group) {
		this.group = group;
	}
	
	@ManyToOne
	@JoinColumn
	private MemberEntity member;//어떤 사용자가 이 글을 썻는지 나타냄
	public void setMember(MemberEntity member) {
		this.member = member;	
	}
}