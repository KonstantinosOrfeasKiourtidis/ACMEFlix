package com.team5.ACMEFlix.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss.SSS")
    private Date backupDate = new Date();

}
