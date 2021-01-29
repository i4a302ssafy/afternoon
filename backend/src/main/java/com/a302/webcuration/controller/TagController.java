package com.a302.webcuration.controller;

import com.a302.webcuration.common.BaseMessage;
import com.a302.webcuration.common.BaseStatus;
import com.a302.webcuration.domain.Tag.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/tags")
@RequiredArgsConstructor
public class TagController {
    private final TagRepository tagRepository;
    @GetMapping
    public ResponseEntity retrieveTagAll(){
        // TODO: 2021-01-28 Tag entity 반환이 아니라 TagDto 반환해야함
        return new ResponseEntity(new BaseMessage(BaseStatus.OK, tagRepository.findAll()), HttpStatus.OK);
    }
}
