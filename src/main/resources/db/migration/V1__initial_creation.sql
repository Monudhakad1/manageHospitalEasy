CREATE TABLE appointment
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    patient_id BIGINT NULL,
    doctor_id  BIGINT NOT NULL,
    date       date NULL,
    CONSTRAINT pk_appointment PRIMARY KEY (id)
);

CREATE TABLE bill
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    patient_id BIGINT NULL,
    amount     DOUBLE NULL,
    status     ENUM(
        'SUCCESSFUL',
        'ON_PROCESS',
        'HALF_DONE',
        'QUARTER_DONE',
        'NOT_COMPLETE',
        'SPECIAL_PATIENT'
        ) NULL,
    CONSTRAINT pk_bill PRIMARY KEY (id)
);

CREATE TABLE doctor
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    name      VARCHAR(255) NULL,
    specialty VARCHAR(255) NULL,
    CONSTRAINT pk_doctor PRIMARY KEY (id)
);

CREATE TABLE patient
(
    id     BIGINT AUTO_INCREMENT NOT NULL,
    name   VARCHAR(255) NULL,
    gender VARCHAR(255) NULL,
    age    VARCHAR(255) NULL,
    CONSTRAINT pk_patient PRIMARY KEY (id)
);