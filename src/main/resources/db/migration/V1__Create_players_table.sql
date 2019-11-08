create table playersData (
    ID int unsigned primary key auto_increment,
    name varchar(25) not null,
    numberOfWins int(8),
    numberOfDraws int(8),
    numberOfLoses int(8),

);
