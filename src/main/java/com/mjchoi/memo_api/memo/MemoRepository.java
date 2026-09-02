package com.mjchoi.memo_api.memo;

import java.util.List;
import java.util.Optional;

public interface MemoRepository {
    Memo save(Memo memo);

    Optional<Memo> findById(Long id);

    List<Memo> findAll();

    void deleteById(Long id);
}
