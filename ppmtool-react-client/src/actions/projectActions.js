import axios from "axios";
import { GET_ERROR, GET_PROJECTS, GET_PROJECT, DELETE_PROJECT } from "./types";

export const createProject = (project, history) => async dispatch => {
  try {
    const resp = await axios.post("/api/project", project);
    history.push("/dashboard");
    dispatch({
      type: GET_ERROR,
      payload: {}
    });
  } catch (err) {
    dispatch({
      type: GET_ERROR,
      payload: err.response.data
    });
  }
};

export const getProjects = () => async dispatch => {
  try {
    const resp = await axios.get("/api/project");
    dispatch({
      type: GET_PROJECTS,
      payload: resp.data
    });
  } catch (err) {}
};

export const getProject = (id, history) => async dispatch => {
  try {
    const resp = await axios.get(`/api/project/${id}`);
    dispatch({
      type: GET_PROJECT,
      payload: resp.data
    });
  } catch (error) {
    history.push("/dashboard");
  }
};

export const deleteProject = id => async dispatch => {
  try {
    await axios.delete(`/api/project/${id}`);
    dispatch({
      type: DELETE_PROJECT,
      payload: id
    });
  } catch (error) {}
};
