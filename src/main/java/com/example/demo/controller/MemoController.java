package com.example.demo.controller;

import com.example.demo.entity.Memo;
import com.example.demo.repository.MemoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        if (!memoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"메모가 없습니다. id=" + id);
        }
        memoRepository.deleteById(id);
    }
}
