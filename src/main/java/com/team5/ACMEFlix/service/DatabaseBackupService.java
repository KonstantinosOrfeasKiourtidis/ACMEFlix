package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.Backup;
import com.team5.ACMEFlix.repository.BackupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DatabaseBackupService {

    @Autowired
    private BackupRepository backupRepository;


    @Transactional
    public int backup(String path) {
        Backup backup = new Backup();
        backupRepository.save(backup);
        return this.backupRepository.backupDB(path);

    }

}
