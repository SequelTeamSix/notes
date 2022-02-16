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
                         painting_id int,
                         artist_id int,
                         title varchar(40),
                         url varchar(40),
                         genre varchar(40),
                         year_made INT,
    --cascading? allowing us to delete entries that other rows rely on by cascading
    --to dependent entries
                         FOREIGN KEY (artist_id) REFERENCES artist(artist_id) ON DELETE CASCADE
);

--let's say we want to have a table that store every exhibition of a painting-
--ie a painting may be shown at many museums, but a museum
--shows many paintings
--to resolve a many-to-many relationship, we need an intermediate table

CREATE TABLE exhibition(
                           exhibition_id int,
                           painting_id int,
                           museum_id int,
                           FOREIGN KEY(painting_id) references painting(painting_id),
                           FOREIGN KEY(museum_id) references museum(museum_id),
);

CREATE TABLE museum(
                       name varchar(40),
                       museum_id int primary key
);

/*normalization is all about maintaining dependencies while reducing redundancy
 * artist table that contains an array containing all of their paintings
 * 1st normal form: all columns must be 'atomic' (meaning that they contain
 * single values), and must contain a primary key
 * in order to achieve, 1nf, the artist table mentioned must split up into
 * multiple rows of the same table, such that all of the items in the paintings column
 * are a single row
 *
 * 		not normalized at all: remedios varo, [p1, p2, p3]'
 *		(why is this bad? what if we want to search by painting?)
 * 		solution:
 * 		1nf: remedios varo, p1
 * 			remedios varo, p2
 *
 * 2nf: cannot have columns that are dependent on only one part of the key (partial dependencies)
 * not in 2nf:
 * pkey(remedios varo, painting1), title
 * pkey(remedios varo, painting2), title
 * (why is this bad? these would be more efficiently spread across tables)
 * solution:
 * artist: remedios varo
 * painting: painting1, title1
 * painting: painting2, title2
 *
 * 3nf: no transitive dependencies
 * artist: remedios varo, salutationID, mrs
 * artist: leonara carrington, salutationID, ms
 * artist: pablo picass, salutationID, mr
 * artist: wassily kandinsky, salutationID, mr
 * (why is this bad? if we change a salutation, we need to change both ms and salutationID)
 *
 * artist: remedios varo, salutationID (1)
 * artist: leonara carrington, salutationID (1) (2-> if leonara gets married)
 *
 * salutationID: 1, mrs
 * salutationID: 2, ms
 *
 * the lesson: redundancy is BAD, we want to always be reducing redundancy,
 * and dependencies are GOOD
 *
 */

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
    (1, 'Composition IX', null, 'Abstract', 1936),
    (2, 'Magic Fishes', null, 'Abstract', 1925),
    (1, 'Gentle Ascent', null, 'Abstract', 1934),
    (3, 'Leaving the Psychoanalyst', null, 'Surrealist', 1960),
    (3, 'Garden of Love', null, 'Surrealist', 1965);
select * from artist;

INSERT INTO painting (artist_id, title, url, genre, year_made)
VALUES
    (1, 'Composition X', null, 'Abstract', 2000);
select * from artist;

/*Sometimes we like to say that SQL is made up of multiple 'sublanguages'
 * DDL, DQL, DML, DCL, TCL
 * DDL - data definition language - creating and altering tables
 * DQL - data query language - queries (select)
 * DML - data manipulation language - updates
 * DCL - data control language - permissions
 * TCL - transaction control language - transactions/commits
 */
--altering tables: changing structure of existing table
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
select sum(year_made) from painting;
--scalar queries
SELECT UPPER(title) as upper_title, genre from painting;

SELECT * FROM PAINTING order by year_made asc;


/*left right joins? if a table from the 'opposite side has no entries,
 * the opposite side will have null in place of values.
 * inner join only counts matches
 */
Select * from (painting left join artist on painting.artist_id = artist.artist_id);
Select * from (painting right join artist on painting.artist_id = artist.artist_id);
/*
 * left/right joins are particularly useful for finding null values:
 * for instance, finding cases where an artist has no paintings
 *
 * for instance, if we have stores that carry items, it's a good way for us to find
 * if a store carries no items
 */
--cross joins? get every possible combination between tables (cross product)
Select * from (painting cross join artist);

--group by? group by like values
--as avg_year? changing name of column in select
Select avg(year_made) as avg_year, genre from painting group by (genre);
--nested query - FIRST find the average year by genre, which generates
--some results that we then select the max from
--as x? in nested queries we need to give inner queries an 'alias'
Select max(avg_year)from
    (Select avg(year_made) as avg_year, genre from painting group by (genre)) as x;

/*
 * updates:
update painting set genre = 'post-impressionism' where artist_id = 1;
select * from painting;

delete from painting where genre = 'post-impressionism';
select * from painting;
*/
--demonstrating cascades
delete from artist where name  = 'Remedios Varo';
select * from painting;
select * from artist;

--set operations
select * from painting where year_made = 1939
union
select * from painting where year_made = 1940;

select * from painting
except
select * from painting where year_made = 1940;

--finding a way to get the second largest item
/*
select top 2 * from painting order by year_made
union
select top 1 * from painting order by year_made;
*/

--select top 1 * from (select * from painting where year_made<max(year_made));

--INDEXES
create index yearGenreIndex on painting (year_made, genre);
/*creating a virtual registry within sql of the order of all items in the table
 * provided this 'key'
 * why?
 * it makes similar queries on this group much faster, particularly if we need large sets of the
 * table
 * in a situation where we are constantly searching for genre and year made simultaneously,
 * it's advantageous for us to create an index on them
 *
 * indexes/ clustered indexes - indexes are 'virtual' (a registry),
 * clustered indexes are physical (change the physical ordering)
 * by default, the primary key
 *
 * create clustered index yearGenreIndex on painting (year_made, genre);
 *
 * we can force an index to be used, but we can only really see speedup by measuring ourselves
 *
 */

select max(year_made), genre from painting group by genre;

create view lastYearForGennre as
select max(year_made) as maxYear, genre from painting group by genre;

select * from lastYearForGennre;
/*what is a materialized view?
 * unlike views, which are updated dynamically, materialized views are a query
 * set in stone: meaning that it is a snapshot of a query at a particular point in time
 *
 * create materialized-view lastYearForGenreMaterialized2 as
select max(year_made) as maxYear, genre from painting group by genre;
 *
 */






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

/*
 * ACID properties:
 * Atomicity
  		either all transactions are completed, or all transactions fail
 * Consistency
 * 		all constrains are met at all times
 * 		for instance, primary/foreign key, not null, check
 * 		checks?
 * 			we can mandate that some conditional is always met:
 * 			like we can say check(year_made < 2023)
 * Isolation
 * 		unrelated transactions do not affect each other
 * 		transactions are separate changes from each other
 * Durability
 * 		our program is resistent to crashes and likely maintains backups,
 * 		and stores unfinished transactions
 *
 * ACID properties, on top of efficiency, are really the real reason we're interested
 * in SQL
 *
 * meaning, we've progressed greatly over eg modifying a .csv file instead
 *
 *
 * if you're interested in going deeper into sql:
 * 	consider procedures, functions,
 * 			(basically methods)
 * triggers
 * 			(automatically call a procedure/function when something happens,
 * 			like adding a value)
 * erd
 * 			(planning, diagramming)
 * nosql
 * (only if you're super interested, no one should be asking you about these things)
 */



