package com.mjchoi.memo_api.memo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memos")
public class MemoController {

    private final MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Memo create(@RequestBody MemoCreateRequest request) {
        return memoService.create(request.title(), request.content());
    }

    @GetMapping("/{id}")
    public Memo findById(@PathVariable Long id) {
        return memoService.findById(id)
                .orElseThrow(() -> new MemoNotFoundException(id));
    }

    @GetMapping
    public List<Memo> findAll() {
        return memoService.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        memoService.delete(id);
    }
}

