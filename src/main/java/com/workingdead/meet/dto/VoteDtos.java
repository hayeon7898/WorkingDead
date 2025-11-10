package com.workingdead.meet.dto;

import jakarta.validation.constraints.*;
import java.time.*;
import java.util.*;


public class VoteDtos {
    public record CreateVoteReq(
            @NotBlank String name,
            LocalDate startDate,
            LocalDate endDate,
            List<String> participantNames  // 참여자 이름 리스트 (optional)
    ) {}
    public record UpdateVoteReq(String name, LocalDate startDate, LocalDate endDate) {}

    public record VoteSummary(Long id, String name, String code, String adminUrl, String shareUrl, LocalDate startDate, LocalDate endDate) {}

    public record VoteDetail(Long id, String name, String code, LocalDate startDate, LocalDate endDate, List<ParticipantDtos.ParticipantRes> participants) {}
}