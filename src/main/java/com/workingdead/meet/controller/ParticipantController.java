package com.workingdead.meet.controller;

import com.workingdead.meet.dto.*;
import com.workingdead.meet.entity.*;
import com.workingdead.meet.repository.*;
import com.workingdead.meet.service.*;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Participant", description = "참여자 관리 API")
@RestController
@RequestMapping("")
public class ParticipantController {
    private final ParticipantService participantService;
    public ParticipantController(ParticipantService participantService) { this.participantService = participantService; }


    // 0.2 참여자 추가/삭제
    @Operation(
            summary = "참여자 추가",
            description = "특정 투표에 새로운 참여자를 추가합니다. displayName을 기반으로 참여자 칩이 생성됩니다."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "참여자 추가 성공",
                    content = @Content(schema = @Schema(implementation = ParticipantDtos.ParticipantRes.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 (displayName이 비어있는 경우)", content = @Content),
            @ApiResponse(responseCode = "404", description = "투표를 찾을 수 없음", content = @Content)
    })
    @PostMapping("/votes/{voteId}/participants")
    public ResponseEntity<ParticipantDtos.ParticipantRes> add(@PathVariable Long voteId, @RequestBody @Valid ParticipantDtos.CreateParticipantReq req) {
        var res = participantService.add(voteId, req.displayName());
        return ResponseEntity.ok(res);
    }

    @Operation(
            summary = "참여자 삭제",
            description = "특정 참여자를 삭제합니다."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "참여자 삭제 성공", content = @Content),
            @ApiResponse(responseCode = "404", description = "참여자를 찾을 수 없음", content = @Content)
    })
    @DeleteMapping("/participants/{participantId}")
    public ResponseEntity<Void> remove(@PathVariable Long participantId) {
        participantService.remove(participantId);
        return ResponseEntity.noContent().build();
    }
}
