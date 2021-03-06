package com.untact.persistent.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.untact.persistent.attendance.AttendanceRepository;
import com.untact.persistent.board.BoardRepository;
import com.untact.persistent.englishdictionary.EnglishDictionaryRepository;
import com.untact.persistent.englishspelling.EnglishSpellingRepository;
import com.untact.persistent.file.FileEntityRepository;
import com.untact.persistent.group.GroupEntityRepository;
import com.untact.persistent.groupinclude.GroupIncludeRepository;
import com.untact.persistent.member.MemberEntityRepository;
import com.untact.persistent.reply.ReplyRepository;
import com.untact.persistent.representativetimetableitem.RepresentativeTimeTableItemRepository;
import com.untact.persistent.timetable.TimeTableRepository;
import com.untact.persistent.timetableitem.TimeTableItemRepository;
import com.untact.persistent.vocabulary.VocabularyRepository;

@Component
public class DeleteAllUtil {
	@Autowired
	private AttendanceRepository attendanceRepo;
	@Autowired
	private BoardRepository boardRepo;
	@Autowired
	private EnglishDictionaryRepository englishDictionaryRepo;
	@Autowired
	private EnglishSpellingRepository englishSpellingRepo;
	@Autowired
	private FileEntityRepository fileRepo;
	@Autowired
	private GroupEntityRepository groupRepo;
	@Autowired
	private GroupIncludeRepository groupIncludeRepo;
	@Autowired
	private MemberEntityRepository memberRepo;
	@Autowired
	private ReplyRepository replyRepo;
	@Autowired
	private RepresentativeTimeTableItemRepository representativeTimeTableItemRepo;
	@Autowired
	private TimeTableItemRepository timeTableItemRepo;
	@Autowired
	private TimeTableRepository timeTableRepo;
	@Autowired
	private VocabularyRepository vocabularyRepo;
	public void deleteAllRepo() {
		attendanceRepo.deleteAllInBatch();
		representativeTimeTableItemRepo.deleteAllInBatch();
		timeTableItemRepo.deleteAllInBatch();
		timeTableRepo.deleteAllInBatch();
		replyRepo.deleteAllInBatch();
		fileRepo.deleteAllInBatch();
		boardRepo.deleteAllInBatch();
		groupIncludeRepo.deleteAllInBatch();
		vocabularyRepo.deleteAllInBatch();
		englishDictionaryRepo.deleteAllInBatch();
		englishSpellingRepo.deleteAllInBatch();
		memberRepo.deleteAllInBatch();
		groupRepo.deleteAllInBatch();
	}
}
