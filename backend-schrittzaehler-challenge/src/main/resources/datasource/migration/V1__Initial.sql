CREATE TYPE competitionStateEnum AS ENUM ('running', 'finished', 'pending');

CREATE TABLE public.competition {
    id bigint NOT NULL,
    startDate date NULL,
    endDate date NULL,
    state competitionStateEnum NOT NULL,
    CONSTRAINT pk_competition PRIMARY KEY (id)
}

CREATE TABLE public.group {
    id bigint NOT NULL,
    competition_id bigint NOT NULL,
    groupname varchar(255) NOT NULL,
    CONSTRAINT pk_group PRIMARY KEY (id),
    CONSTRAINT fk_competition_id FOREIGN KEY (competition_id)
        REFERENCES competition (id)
}

CREATE TYPE userRoleEnum AS ENUM ('admin', 'normal');

CREATE TABLE public.user {
    id bigint NOT NULL,
    group_id bigint NOT NULL,
    username varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    dailyStepGoal INT NULL,
    userRole userRoleEnum NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id),
    CONSTRAINT fk_group_id FOREIGN KEY (group_id)
        REFERENCES group (id)
}

CREATE TABLE public.steps {
    id bigint NOT NULL,
    user_id bigint NOT NULL,
    numberOfSteps INT NOT NULL,
    creationDate date NOT NULL,
    CONSTRAINT pk_steps PRIMARY KEY (id),
    CONSTRAINT fk_user_id FOREIGN KEY (user_id)
        REFERENCES user (id)
}