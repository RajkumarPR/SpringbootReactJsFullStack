import axios from "axios";
import { GET_ERROR, GET_PROJECTS } from "./types";

export const createProject = (project, history) => async dispatch => {
  try {
    const resp = await axios.post("http://localhost:8080/api/project", project);
    history.push("/dashboard");
  } catch (err) {
    dispatch({
      type: GET_ERROR,
      payload: err.response.data
    });
  }
};

export const getProjects = () => async dispatch => {
  try {
    const resp = await axios.get("http://localhost:8080/api/project");
    dispatch({
      type: GET_PROJECTS,
      payload: resp.data
    });
  } catch (err) {}
};
