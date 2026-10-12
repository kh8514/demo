package com.example.demo.controller;

import com.example.demo.entity.Memo;
import com.example.demo.repository.MemoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/memos")
public class MemoController {

    private final MemoRepository memoRepository;

    public MemoController(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    @PostMapping
    public Memo create(@RequestBody Memo memo) {
        memo.setId(null);
        return memoRepository.save(memo);
    }

    @GetMapping
    public List<Memo> findAll() {
        return memoRepository.findAll();
    }
}
