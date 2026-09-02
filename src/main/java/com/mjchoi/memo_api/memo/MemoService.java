package com.mjchoi.memo_api.memo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemoService {
    private final MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public Memo create(String title, String content) {
        Memo memo = new Memo(null, title, content, null);
        return memoRepository.save(memo);
    }

    public Optional<Memo> findById(Long id) {
        return this.memoRepository.findById(id);
    }

    public List<Memo> findAll() {
        return this.memoRepository.findAll();
    }

    public void delete(Long id) {
        this.memoRepository.deleteById(id);
    }
}
