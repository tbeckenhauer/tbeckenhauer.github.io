---
layout: post
title: "Domain Models Driving Exception Tunneling: From Frontend to Backend"
description: "A practical guide to handling exceptions and validation from the frontend in Vue3 & Vuex to the backend in Kotlin with Spring Boot."
date: 2023-09-20 14:30:00 -0700
categories: [software-development, vue3, kotlin]
tags: [exception-handling, vue3, vuex, kotlin, spring-boot, domain-driven-development]
author: [Thomas Beckenhauer]
---


---

## Handling Exceptions with Vue3 & Kotlin: From Frontend to Backend

In the [previous post](/style_guides/tunneling-input-exceptions-to-output-exceptions), we discussed the essence of "Tunneling Input Exceptions to Output Exceptions". Today, we'll delve deeper into the practical application of this principle, examining the flow from the frontend (Vue3 & Vuex) to the backend (Kotlin with Spring Boot).

### Domain Objects

1. **Person**:
   - `name`: String
   - `age`: Integer
   - `email`: String
   
2. **Store Location**:
   - `address`: String
   - `city`: String
   - `postalCode`: String

3. **Transaction**:
   - `id`: UUID
   - `person`: Person
   - `storeLocation`: Store Location
   - `amount`: Double

4. **Transaction Log**:
   - `transaction`: Transaction
   - `timestamp`: DateTime
   - `status`: Enum (SUCCESS, FAILED, PENDING)

### Vue3 & Vuex: Object Verification and Exception Handling

Object verification can be encapsulated into Vuex actions. For our `TransactionLog`, the verification looks like:

```javascript
// Vuex Store
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    transactionLogs: [],
    // ... other state properties ...
  },
  mutations: {
    setTransactionLogs(state, logs) {
      state.transactionLogs = logs
    },
    // ... other mutations ...
  },
  actions: {
    fetchTransactionLogs({ commit }) {
      // Assume we make an API call to get logs
      apiCall().then(data => {
        if (!validateTransactionLogs(data)) {
          throw new Error("Invalid Transaction Logs")
        }
        commit('setTransactionLogs', data)
      }).catch(error => {
        // Handle the error appropriately, perhaps setting an error state
      })
    },
    // ... other actions ...
  }
})

function validateTransactionLogs(logs) {
  // Simple validation; expand for a real-world app
  return logs.every(log => 'transaction' in log && 'timestamp' in log && 'status' in log)
}
```

For the Vue component:

```vue
<template>
  <div>
    <div v-if="error">An error occurred: {{ error.message }}</div>
    <div v-else>
      <ul>
        <li v-for="log in transactionLogs">{{ log.transaction.id }} - {{ log.timestamp }}</li>
      </ul>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  computed: mapState(['transactionLogs', 'error']),
  created() {
    this.$store.dispatch('fetchTransactionLogs')
  }
}
</script>
```

### Kotlin Backend: Verifying and Tunneling Exceptions

On the backend, every received object should be verified before any business logic is applied.

```kotlin
@RestController
@RequestMapping("/api/transactions")
class TransactionController(private val transactionService: TransactionService) {

    @GetMapping
    fun getTransactions(): ResponseEntity<Any> {
        return try {
            val transactions = transactionService.getTransactions()
            ResponseEntity.ok(transactions)
        } catch (ex: InvalidTransactionException) {
            ResponseEntity.badRequest().body(ex.message)
        }
    }

    // ... other endpoints ...
}

@Service
class TransactionService(private val transactionRepo: TransactionRepo) {

    fun getTransactions(): List<Transaction> {
        val transactions = transactionRepo.findAll()
        transactions.forEach { validateTransaction(it) }
        return transactions
    }

    private fun validateTransaction(transaction: Transaction) {
        if (transaction.person.name.isEmpty()) {
            throw InvalidTransactionException("Invalid name.")
        }
        // ... other validations ...
    }
}
```

Here, the `validateTransaction` function checks the validity of the transaction object. If it finds any inconsistencies, it throws an `InvalidTransactionException`.

### Database Logic

For the database layer, let's consider using Spring Data JPA. Whenever reading from or writing to the database, validation is again crucial:

```kotlin
@Entity
data class Transaction(
    @Id @GeneratedValue
    val id: UUID,
    @ManyToOne
    val person: Person,
    // ... other fields ...
)

@Repository
interface TransactionRepo : JpaRepository<Transaction, UUID>
```

---

**Conclusion**

From Vue3 & Vuex on the frontend to Kotlin with Spring Boot on the backend, the principle remains consistent: validate early, throw exceptions for inconsistencies, and handle them gracefully. Such robust design ensures an intuitive user experience and system reliability.

---

This is an overview tailored to your request. Expand upon the code examples and structure to align with the specific requirements of your real-world application.