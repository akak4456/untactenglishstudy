package com.untact.domain.englishdictionary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.untact.domain.englishspelling.EnglishSpelling;
import com.untact.domain.thesaurus.Thesaurus;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "spelling", "partOfSpeech", "meaning" }))
@SequenceGenerator(name="ed_seq", initialValue=1, allocationSize=1)
@EqualsAndHashCode(of="edno")
public class EnglishDictionary {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="ed_seq")
	private Long edno;
	@ManyToOne
	@JoinColumn(name="spelling")
	private EnglishSpelling englishSpelling;
	public void setEnglishSpelling(EnglishSpelling englishSpelling) {
		this.englishSpelling = englishSpelling;
	}
	
	private String partOfSpeech;//품사
	
	private String meaning;
}
