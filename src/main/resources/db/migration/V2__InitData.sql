insert into team (id, name, established_date, stadium, fight_song, mascot)
values (1, 'bengals', '1967-05-23', 'paycor', 'the bengals growl', 'who dey');

insert into location (team, city, state, state_code, zip_code)
values (1, 'cincinnati', 'ohio', 'oh', '45201');

insert into head_coach(team, first_name, last_name, wins, losses, ties)
values (1, 'zac', 'taylor', 26, 36, 1);