# Sorting
Input message
``[
  {
    "name": "Accessories",
    "id": 1,
    "parent_id": 20,
  },
  {
    "name": "Watches",
    "id": 57,
    "parent_id": 1
  },
  {
    "name": "Men",
    "id": 20,
    "parent_id": null,
  }
]``
This is a formatted JSON sample solution for the input above:

``[
  {
    "name": "Men",
    "id": 20,
    "parent_id": null
  },
  {
    "name": "Accessories",
    "id": 1,
    "parent_id": 20
  },
  {
    "name": "Watches",
    "id": 57,
    "parent_id": 1
  }
]``
