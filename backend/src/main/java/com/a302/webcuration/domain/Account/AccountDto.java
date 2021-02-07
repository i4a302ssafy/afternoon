package com.a302.webcuration.domain.Account;

import com.a302.webcuration.domain.Tag.Tag;
import com.a302.webcuration.domain.Tag.TagDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.modelmapper.ModelMapper;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AccountDto {


    @Getter
    //계정 팔로잉
    @Setter
    @RequiredArgsConstructor
    public static class FollowRequest {
        @NotNull
        private Long yourId;
    }

    @Getter @Setter @RequiredArgsConstructor
    //팔로워
    public static class FollowerDto{
        private Long id;
        private String name;
        private String nickname;
    }

    @Getter @Setter @RequiredArgsConstructor
    //팔로워
    public static class FollowingDto{
        private Long id;
        private String name;
        private String nickname;
    }

    // TODO: 2021-02-06 accountId,Desc->Bio 프로필 사진(엔티티까지 수정), 내 모든 posts, 내가 좋아요한 게시물, 내 관심태그, 좋아요한 게시물 수, 게시물 수
    @Getter @Setter @RequiredArgsConstructor
    public static class AccountProfile{

        private String accountName;

        private String accountNickname;

        private String accountEmail;

        private LocalDate accountCreateDate;

        private String accountDesc;

        private List<AccountDto.FollowingDto> following;

        private List<AccountDto.FollowerDto> follower;

        private int accountFollowingCnt;

        private int accountFollowerCnt;

    }

    @Getter @Setter @RequiredArgsConstructor
    public static class UpdateRequest
    {
        private String accountDesc;
        //닉네임도 수정할 지 말지 생각
        private String accountNickname;
    }

    @Getter @Setter @Builder
    //계정 생성 요청
    public static class CreateAccountRequest
    {
        @NotNull
        private String accountName;

        @NotNull
        private String accountNickname;

        @NotNull
        @Email(message = "알맞은 이메일 형식으로 입력해주세요.")
        private String accountEmail;

        public Account toEntity()
        {
            return Account.builder()
                    .accountName(this.accountName)
                    .accountNickname(this.accountNickname)
                    .accountEmail(this.accountEmail)
                    .build();
        }
    }
    @Getter @Setter
    //계정 생성 결과
    public static class CreateAccountResponse
    {
        private Long accountId;

        private String accountName;
        private String accountNickname;
        private String accountEmail;

        private LocalDate accountCreateDate;
        private LocalDate accountUpdateDate;

        private Role accountRole;
        private String accountDesc;

    }
    @Getter @Setter @RequiredArgsConstructor
    public static class LoginRequest{

        //TODO
        //@NotNull
        private String act;

        @Email(message = "알맞은 이메일 형식이 아닙니다.")
        private String accountEmail;
        private String accountAuthKey;

        private Long accountId;

    }

    @Getter @Setter @RequiredArgsConstructor
    public static class AccountInfoInHeader{
        private Long accountId;
        private String accountEmail;
    }
    //태그 설정
    @Getter @Setter @RequiredArgsConstructor
    public static class AccountTagRequest{
        //private List<String> tagName=new ArrayList<>();
        private List<TagDto.Tag> tags=new ArrayList<>();
    }

}
