const express = require("express");
const router = express.Router();
const courseController = require("../controllers/courseController");

router.get("/", courseController.getCourses);
router.get("/:id", courseController.getCourseDetails);

module.exports = router;