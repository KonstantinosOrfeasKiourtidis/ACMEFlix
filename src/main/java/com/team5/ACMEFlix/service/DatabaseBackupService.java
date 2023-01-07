package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.repository.BackupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DatabaseBackupService {

    @Autowired
    private BackupRepository backupRepository;

    public DatabaseBackupService(BackupRepository backupRepository) {
        this.backupRepository = backupRepository;
    }

    public int backup(String path) {
      return this.backupRepository.backupDB(path);

    }

}
