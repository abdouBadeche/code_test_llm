const request = require("supertest");
const app = require("../app");

describe("Auth API", () => {
    it("should register a new user", async () => {
        const response = await request(app)
            .post("/api/auth/register")
            .send({
                firstName: "John",
                lastName: "Doe",
                email: "john.doe@example.com",
                password: "password",
            });

        expect(response.status).toBe(201);
        expect(response.body).toHaveProperty("token");
    });

    it("should login an existing user", async () => {
        const response = await request(app)
            .post("/api/auth/login")
            .send({
                email: "john.doe@example.com",
                password: "password",
            });

        expect(response.status).toBe(200);
        expect(response.body).toHaveProperty("token");
    });
});