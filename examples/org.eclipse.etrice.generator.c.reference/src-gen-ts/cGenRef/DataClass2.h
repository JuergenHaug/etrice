/**
 * @author generated by eTrice
 *
 * Header File of DataClass DataClass2
 * 
 */

#ifndef _DATACLASS2_H_
#define _DATACLASS2_H_

#include "etDatatypes.h"


		
typedef struct {
	/*--------------------- attributes ---------------------*/
	int32 Attr1;
	float32 Attr2;
	int32 Attr3;
} DataClass2;



/*--------------------- operations ---------------------*/
void DataClass2_Operation1(DataClass2* self);

/* deep copy */
void DataClass2_deepCopy(DataClass2* source, DataClass2* target);


#endif /* _DATACLASS2_H_ */
