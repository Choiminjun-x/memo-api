package com.mjchoi.memo_api.memo;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryMemoRepository implements MemoRepository {

    private final Map<Long, Memo> store = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong();

    @Override
    public Memo save(Memo memo) {
        Long id = sequence.incrementAndGet();
        Memo saved = new Memo(id, memo.title(), memo.content(), LocalDateTime.now());
        store.put(id, saved);
        return saved;
    }

    @Override
    public Optional<Memo> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Memo> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }
}
