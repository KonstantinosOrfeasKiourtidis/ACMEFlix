package com.team5.ACMEFlix.scheduler;

import com.team5.ACMEFlix.service.DatabaseBackupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private final DatabaseBackupService databaseBackupService;

    @Autowired
    private ScheduledTasks(DatabaseBackupService databaseBackupService) {
        this.databaseBackupService = databaseBackupService;
    }
    @Scheduled(fixedRate = 60000)
    public void reportCurrentTime() throws SQLException, IOException, ClassNotFoundException {

        log.info("The time is now {}", dateFormat.format(new Date()));
        databaseBackupService.backup("Backup");

    }
}