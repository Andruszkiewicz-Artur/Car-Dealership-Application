package com.andruszkiewicz.cardealershipapplication.networking.utils

object NetworkUtils {

    const val BASE_URL = "http://10.0.2.2:7474/"

    fun images(idCar: Int): List<String> = when (idCar) {
            1 -> {
                listOf(
                    "https://github.com/user-attachments/assets/70b1ae3d-976a-41d5-8dcc-d57c92a55b9e",
                    "https://github.com/user-attachments/assets/e80d058e-b47e-4434-ac8a-182a3481f503",
                    "https://github.com/user-attachments/assets/7c08ee7f-532a-4929-9ad6-629ed3a5c7e2",
                    "https://github.com/user-attachments/assets/73a58b77-e448-4637-96fa-1b3f6ddfd3b4",
                    "https://github.com/user-attachments/assets/6d2e7b9f-232f-4169-92b5-dcc9042453d3"
                )
            }
            2 -> {
                listOf(
                    "https://github.com/user-attachments/assets/21f68c43-ab6a-4c80-b546-12f8a8f47970",
                    "https://github.com/user-attachments/assets/5102b9ed-5ef5-468a-b5ca-ebb7bce72e68",
                    "https://github.com/user-attachments/assets/ef9b7839-5a57-44cf-acfb-5c0c3241841a",
                    "https://github.com/user-attachments/assets/7b62f919-7070-4d9b-b068-63a9106d2e26",
                    "https://github.com/user-attachments/assets/24d4ad20-e6f0-46c7-8eac-5448c7754b92"
                )
            }
            3 -> {
                listOf(
                    "https://github.com/user-attachments/assets/72358248-ffec-4a00-80d6-19cf4e9fd53d",
                    "https://github.com/user-attachments/assets/2350c24a-7ebd-484a-a18f-db058be1930b",
                    "https://github.com/user-attachments/assets/ac49de27-83e5-4495-bd51-170f8e9b62af",
                    "https://github.com/user-attachments/assets/0317ef87-f15a-4db5-a608-7a82b7d8c502",
                    "https://github.com/user-attachments/assets/2558be5a-8a4c-4bfa-b75b-420bb9e60053"
                )
            }
            4 -> {
                listOf(
                    "https://github.com/user-attachments/assets/886594d3-b9f3-4d95-b385-397e2785e88c",
                    "https://github.com/user-attachments/assets/c8ee6e35-e2f5-4d96-b1e2-544d85d1feb7",
                    "https://github.com/user-attachments/assets/a4323008-6ec2-4199-8edd-acead6b7c39e",
                    "https://github.com/user-attachments/assets/d6bce1a2-f532-4879-bdc3-355379f20742",
                    "https://github.com/user-attachments/assets/bd1e5afb-4a48-4b3b-a7ae-55db21ae346d"
                )
            }
            5 -> {
                listOf(
                    "https://github.com/user-attachments/assets/d046ebda-5d70-4ff6-8acc-8099ba8b0c53",
                    "https://github.com/user-attachments/assets/50d8df35-5077-48c5-b6c5-c912bf7b5e12",
                    "https://github.com/user-attachments/assets/7ac88e02-a572-45f4-a41b-7e51cf622f92",
                    "https://github.com/user-attachments/assets/c45b67e1-28c3-48d0-8f00-62991130aa2b",
                    "https://github.com/user-attachments/assets/62d7fb1a-ce46-4891-a396-8f21eae01a33"
                )
            }
            6 -> {
                listOf(
                    "https://github.com/user-attachments/assets/29241d42-a460-4917-88f7-b01fe0663ece",
                    "https://github.com/user-attachments/assets/fcb26250-dae0-4df1-9272-aab40bb81ae7",
                    "https://github.com/user-attachments/assets/f9729a3c-1374-4551-9083-ad2c869a6aa8",
                    "https://github.com/user-attachments/assets/2d073c4c-2477-42ec-8914-3ec51983af7f",
                    "https://github.com/user-attachments/assets/48c45ea8-4768-4438-a7a5-aed9950406a5"
                )
            }
            7 -> {
                listOf(
                    "https://github.com/user-attachments/assets/6629f082-be22-4190-a7aa-907c47ebf5fc",
                    "https://github.com/user-attachments/assets/d21ab5a8-b244-4ff1-a958-02ba3d99f00e",
                    "https://github.com/user-attachments/assets/a942600b-9c0d-4a2a-b709-cc1527676306",
                    "https://github.com/user-attachments/assets/31cef198-8375-4b90-90b6-0d894541a427",
                    "https://github.com/user-attachments/assets/11e7b629-bada-48f0-bbcf-d5b0e9007f15"
                )
            }
            8 -> {
                listOf(
                    "https://github.com/user-attachments/assets/ae009a36-38c0-4dbb-ab82-fa3f389bbe34",
                    "https://github.com/user-attachments/assets/90eb8ffb-375e-49a5-9f06-2082728acc5f",
                    "https://github.com/user-attachments/assets/5f6717be-a61a-44df-83b8-892bc38a4ec5",
                    "https://github.com/user-attachments/assets/5402b59c-76de-4f98-94a1-fca229c9f0ed",
                    "https://github.com/user-attachments/assets/f4cab0b9-02df-4f1a-9d22-5560b0dd9846"
                )
            }
            9 -> {
                listOf(
                    "https://github.com/user-attachments/assets/e6c20b0e-8349-4e87-92f3-a9f134459bb7",
                    "https://github.com/user-attachments/assets/b530f724-6339-4eaf-ac99-db10fc27afb1",
                    "https://github.com/user-attachments/assets/2b90ee15-5857-4fd9-af36-57ffd6851260",
                    "https://github.com/user-attachments/assets/c48773eb-b71f-495c-8af5-1e4185e0eb45",
                    "https://github.com/user-attachments/assets/db49a33e-3a30-42cf-a3c5-3dd02ab67985"
                )
            }
            10 -> {
                listOf(
                    "https://github.com/user-attachments/assets/8b0a6259-36aa-4c3d-a945-6286f6be758a",
                    "https://github.com/user-attachments/assets/3fd282f1-fe0a-47db-8e65-effd95d1d30b",
                    "https://github.com/user-attachments/assets/7d9dcc51-ca80-4c68-8d7b-3fcefc123581",
                    "https://github.com/user-attachments/assets/b4010760-3348-4da5-aa27-0fdeb022d78e",
                    "https://github.com/user-attachments/assets/0b5511c6-7a38-4e2d-a1ec-36d57fe63240"
                )
            }
            else -> emptyList()
        }

}