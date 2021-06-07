Another approach (same complexity as naive) with 2 pointers method:

-> For a given list; when N-th element from last node is required to be found: 

1. Prepare 2 pointers 'forward' & 'current' such a way that they have a gap of 'N' between them.

2. Move both pointers one position at a time such that 'forward' becomes NULL. The value of 'current' will be required value. 