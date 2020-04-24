
description project:

framework : spring boot
language : java 11
database : posgresql 12
ide : intelij
type : maven project

port :9000

api : localhost:9000/api/loyalty-card/transaction/add
data sample : 
{
	"loyaltyCardId" : 1,
	"spentAdjust" : 5000000
}

api : localhost:9000/api/loyalty-card/config
data sample : 
{
	"pointOfConversion": 100
}

