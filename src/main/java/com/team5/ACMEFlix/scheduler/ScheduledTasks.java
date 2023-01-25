package com.team5.ACMEFlix.scheduler;

import com.team5.ACMEFlix.service.BackupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.SQLException;

@Component
public class ScheduledTasks {

    private final BackupService backupService;

    @Autowired
    private ScheduledTasks(BackupService backupService) {
        this.backupService = backupService;
    }
    @Scheduled(fixedRate = 60000)
    public void reportCurrentTime() throws SQLException, IOException, ClassNotFoundException {
        backupService.backup("Backup");
    }
}