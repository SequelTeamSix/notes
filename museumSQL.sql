/*
Why do we use the cloud?
not spend so much on server resources
Microsoft Azure is among many cloud providers - 
the real big player is AWS, but its market share is shrinking because of the growth in Azure and GCP
why cloud?
global availability - regional data centers
high availability - region pairing
scalability
	if we have high usage at one point, we can auto scale up or auto scale down
	which means our money is being used more efficiently

Infrastructure as a service
	purchasing a virtual machine
Platform as a service
	azure devops
		azure devops just runs some script that we feed it builds our project (maven) for us
	azure sql
Software as a service
	salesforce, servicenow, pega
	
SQL?
Structured Query Language
Relational Database
whats that?
Items in one table can be related to items in another
There are many flavors of SQL - because native SQL is pretty simplistic,
many versions have been created to add new features (mysql, postgres, azuresql)

NoSQL
MongoDB, Cosmos, Cassandra

datatypes:
numeric:
int
bigint
float
money

strings:
char
varchar

binary:
bit
blob
clob
file

others:
date
datetime

in dbeaver, running single line at cursor: ctrl enter
running whole script: alt x

issues with non-relational organization
	1. redundancy
	2. what if a value needs to change?
	
constraints
primary key:
	the primary key MUST be unique
	the primary key MUST exist (not null)
	primary keys are indexed by default
	
foreign keys:
	MUST refer to an existing primary key
	
What we did with reducing redundancy between tables while maintaining the 
dependency between painting and artist tables will relate to a topic
which we will talk about later - normalization

multiplicity - we can say that x amount of a correspond to y amount of b
for example, an artist many have many paintings
(many to one)
many paintings can be exhibited (over a single paintings lifetime) at many museums
(many to many)
a single thing might map to another single thing
(one to one)

entity relational diagrams - not something we'll look into but thanks for bringing it up

*/

DROP TABLE IF EXISTS painting;
DROP TABLE IF EXISTS artist;


CREATE TABLE artist(
                       artist_id int IDENTITY(1,1) PRIMARY KEY,
                       name varchar(40) NOT NULL
);

CREATE TABLE painting(
                         artist_id int,
                         title varchar(40),
                         url varchar(40),
                         genre varchar(40),
                         year_made INT,
                         FOREIGN KEY (artist_id) REFERENCES artist(artist_id) ON DELETE CASCADE
);

INSERT INTO artist (name)
VALUES
    ('Wasilly Kandinsky'),
    ('Paul Klee'),
    ('Remedios Varo');


INSERT INTO artist (name)
VALUES
    ('Pablo Picasso');

INSERT INTO painting (artist_id, title, url, genre, year_made)
VALUES
    (1, 'Composition IX', null, 'Abstract', 1939),
    (2, 'Magic Fishes', null, 'Abstract', 1938),
    (1, 'Gentele Ascent', null, 'Abstract', 1940),
    (3, 'Leaving the Psychoanalyst', null, 'Surrealist', 1960),
    (3, 'Garden of Love', null, 'Surrealist', 1965);
select * from artist;

/*Sometimes we like to say that SQL is made up of multiple 'sublanguages'
 * DDL, DQL, DML, DCL, TCL
 * DDL - creating and altering tables
 * DQL - queries
 * DML - updates
 * DCL - permissions
 * TCL - transactions/commits
 */

ALTER TABLE Painting ADD painting_type varchar(40);
select * from Painting;



SELECT * FROM painting;
SELECT title, year_made FROM painting;
SELECT title, name FROM (painting join artist on painting.artist_id = artist.artist_id);

SELECT * FROM painting where title = 'Composition IX';

/*aggregate queries*
 * 
 */
SELECT avg(year_made) FROM painting;
--scalar queries
SELECT UPPER(title) as upper_title, genre from painting;

SELECT * FROM PAINTING order by year_made asc;

Select * from (painting left join artist on painting.artist_id = artist.artist_id);
Select * from (painting right join artist on painting.artist_id = artist.artist_id);
/*
 * left/right joins are particularly useful for finding null values:
 * for instance, finding cases where an artist has no paintings
 * 
 * for instance, if we have stores that carry items, it's a good way for us to find
 * if a store carries no items
 */

Select * from (painting cross join artist);

Select avg(year_made) as avg_year, genre from painting group by (genre);

Select max(avg_year)from
    (Select avg(year_made) as avg_year, genre from painting group by (genre)) as x;
/*
update painting set genre = 'post-impressionism' where artist_id = 1;
select * from painting;

delete from painting where genre = 'post-impressionism';
select * from painting;
*/
delete from artist where name  = 'Remedios Varo';
select * from painting;
select * from artist;

select * from painting where year_made = 1939
union
select * from painting where year_made = 1940;

select * from painting
except
select * from painting where year_made = 1940;

(select top 2 * from painting order by year_made asc)
except
(select top 1 * from painting order by year_made asc);


/*
 * text adventure game
 * certain amount of rooms?
 * turns?
 * 
 * 
 * rpg video game?
 * creator
 * maintain a db table with all of the abilities you can pick
 * add functionality for user to select from list, which perhaps adds to
 * an object in java which contains all abilities
 * 
 * dungeon rpg?
 * levelling up
 * 
 * zombie killer?
 * backpack with items
 * zombie fighter?
 * central menu
 * 	functionality to select an item (which is presented as list from db)
 * 	functionality to select a zombie (list from db)
 *  test fight
 * 
 * content selector?
 * inputs: how much time
 * desired mood
 * return series of things to watch
 * 
 * math scavenger hunt?
 * for every math problem correct
 * recieve item from list
 * table:
 * 		problems
 * 		correct answer
 * 		id of reward
 * 
 *  
 */



