/**
 * @author generated by eTrice
 *
 * Utils File of DataClass DTcpPayload
 * 
 */

#ifndef _ETRICE_API_TCP_DTCPPAYLOAD_UTILS_H_
#define _ETRICE_API_TCP_DTCPPAYLOAD_UTILS_H_

#include "etrice/api/tcp/DTcpPayload.h"

/*
 * access macros for operations and attributes
*/

/* operations */
#define getMaxLength() DTcpPayload_getMaxLength(self)
#define setAsString(value) DTcpPayload_setAsString(self, value)
#define setData(value, size) DTcpPayload_setData(self, value, size)
#define getAsString() DTcpPayload_getAsString(self)

/* attributes */
#define connectionId (self->connectionId)
#define length (self->length)
#define data (self->data)

#endif /* _ETRICE_API_TCP_DTCPPAYLOAD_UTILS_H_ */

