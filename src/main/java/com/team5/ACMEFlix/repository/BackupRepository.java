package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.Backup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BackupRepository extends JpaRepository<Backup, Long> {

    @Modifying
    @Transactional
    @Query(value = "BACKUP TO 'backup.zip'", nativeQuery = true)
    int backupDB(String path);
}
