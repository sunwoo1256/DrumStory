package drumstory.drumstory.controller;

import drumstory.drumstory.DTO.AdminMemberDTO;
import drumstory.drumstory.domain.Member;
import drumstory.drumstory.service.AdminMemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Tag(name = "관리자 페이지")
public class AdminMemberController {

    private final AdminMemberService adminMemberService;

    @Operation(summary = "회원 추가(선우)", description = "토큰 필요",
            responses = {@ApiResponse(responseCode = "201", description = "생성"),
                    @ApiResponse(responseCode = "409", description = "중복 ID임")})
    @PostMapping("/admin/member/add")
    public ResponseEntity<AdminMemberDTO.AddMemberResponse> addMember(@RequestBody AdminMemberDTO.AdminCreateMemberDTO request){
        Member member = adminMemberService.add(request.getName(), request.getPhoneNumber(), request.getMemberNum());
        return ResponseEntity.status(HttpStatus.CREATED).body(new AdminMemberDTO.AddMemberResponse(member.getMemberNum(), member.getName(), member.getRole()));
    }

    @Operation(summary = "회원 조회(선우)", description = "토큰 필요",
            responses = {@ApiResponse(responseCode = "200", description = "조회")})
    @GetMapping("/admin/member")
    public List<Member> getAllMembers(){
        return adminMemberService.findAll();
    }
}
