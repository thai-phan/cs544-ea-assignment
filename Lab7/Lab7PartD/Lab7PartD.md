When no @Transactional 

There is error failed to lazily initialize a collection of role: bank.domain.Account.entryList: could not initialize proxy - no Session

Because the session is closed.
annotation is used, the method runs in a non-transactional context.

When @Transactional is used:

Opens a database transaction before the method starts

Executes all the logic (including JPA operations like save(), delete(), find(), etc.)

If everything is successful → commits the transaction

If any exception occurs → rolls back the transaction