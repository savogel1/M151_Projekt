INSERT INTO public.competition(name, start_date, end_date, state) VALUES ('competition 1', '2021-06-07', '2021-07-07', 'running');

INSERT INTO public.group(competition_id, groupname) VALUES (1, 'testgroup1'), (1, 'testgroup2');

INSERT INTO public.user(group_id, username, password, email, daily_step_goal, user_role) VALUES (1, 'sacha', 'admin', 'sacha@test.com', 8000, 'admin'), (2, 'janis', 'normal', 'janis@test.com', 9000, 'normal');

INSERT INTO public.step(user_id, number_of_steps, creation_date) VALUES (1, 6969, '2021-06-07'), (2, 9999, '2021-06-08'), (1, 2000, '2021-06-09');