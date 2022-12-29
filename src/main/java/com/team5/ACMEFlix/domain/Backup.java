package com.team5.ACMEFlix.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "BACKUPS", indexes = {@Index(columnList = "backupDate")})
@SequenceGenerator(name = "idGenerator", sequenceName = "BACKUPS_SEQ", initialValue = 1, allocationSize = 1)
public class Backup extends BaseModel{
    private Date backupDate;
}
